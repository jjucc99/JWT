package com.sparta.springcore.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidationTest {

    @Nested
    @DisplayName("username 검증 테스트")
    class username {
        String regex = "^[A-Za-z0-9]{3,}$";
        String fail = "asdfagawer#!@#SAD";
        String success = "yyuoqweasdxz123123";

        @Test
        @DisplayName("성공")
        void setSuccess(){
            boolean matchesSuccess = success.matches(regex);

            assertTrue(matchesSuccess);
        }

        @Test
        @DisplayName("한글이 들어왔을 때")
        void setKorean(){
            fail = "이것은 한글입니다.";
            boolean matches = fail.matches(regex);

            assertFalse(matches);
        }
    }

    @Nested
    @DisplayName("비밀번호 검증 테스트")
    class password {
        String fail = "cbn";
        String success = "tyu123";

        @Nested
        @DisplayName("비밀 번호 생성 테스트")
        class checkPassword{
            @Test
            @DisplayName("비밀 번호에 닉네임과 같은 문자가 들어가 있는 가?")
            void setSuccess() {
                boolean check = false;

                // given
                String username = "yyuoqweasdxz123123";

                String[] split = username.split("");
                for (String s : split) {
                    boolean contains = success.contains(s);
                    if (contains) {
                        check = true;
                        break;
                    }
                }

                assertTrue(check);

                check = false;

                for (String s : split) {
                    boolean contains = fail.contains(s);
                    if (contains) {
                        check = true;
                        break;
                    }
                }

                assertFalse(check);
            }
            @Test
            @DisplayName("비밀번호의 길이가 4이상 인가?")
            void setLength() {
                assertTrue(success.length() >= 4);
                assertFalse(fail.length() >= 4);

            }
            @Test
            @DisplayName("비밀 번호 확인과 비밀번호가 같은가?")
            void setPassword() {
                String checkPassword = "tyu123";
                String failPassword = "cbn";

                assertEquals(success, checkPassword);
                assertNotEquals(success, failPassword);
            }
        }
    }
}