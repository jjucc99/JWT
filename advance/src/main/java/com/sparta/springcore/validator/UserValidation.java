package com.sparta.springcore.validator;

public class UserValidation {

    public static String validatedUsername(String username) {
        if (!username.matches("^[A-Za-z0-9]{3,}$")) {
            throw new IllegalArgumentException("닉네임 또는 패스워드를 확인해 주세요");
        }
        return username;
    }

    public static String validatedPassword(String username, String password, String checkPassword) {
        if (!(password.length() >= 4)) {
            throw new IllegalArgumentException("비밀 번호의 길이가 4 이하 입니다");
        }
        if (!checkPassword.equals(password)){
            throw new IllegalArgumentException("비밀번호 확인과 비밀번호가 같지 않습니다.");
        }


        String[] split = password.split("");
        for (String s : split) {
            boolean contains = username.contains(s);
            if (contains) {
                throw new IllegalArgumentException("닉네임과 같은 값이 포함된 경우 회원가입 불가합니다.");
            }
        }

        return password;
    }
}
