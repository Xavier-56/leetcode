public class LeetCode2023_1_19_2299强密码检验器II {
    public boolean strongPasswordCheckerII(String password) {
        String special = "!@#$%^&*()-+";
        if (password.length() < 8) return false;
        boolean hasBig = false, hasSmall = false, hasDigital = false, hasSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            char p = password.charAt(i);
            if (p >= 'a' && p <= 'z') hasSmall = true;
            if (p >= 'A' && p <= 'Z') hasBig = true;
            if (Character.isDigit(p)) hasDigital = true;
            for (int j = 0; j < special.length(); j++) {
                if (special.charAt(j) == p) {
                    hasSpecial = true;
                    break;
                }
            }
            if (i > 0 && p == password.charAt(i - 1)) return false;
        }
        if (hasBig && hasDigital && hasSmall && hasSpecial) return true;
        else return false;
//        String pattern = "/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\!@#$%\\^&\\*\\(\\)\\-\\+])(?!.*(.)\\1+).{8,}$/";
//        return password.matches(pattern);
    }
}
