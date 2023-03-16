package hugeinteger;

public class HugeInteger {
    public String number;
    public int len;

    HugeInteger(String num) {
        this.number = num;
        this.len = this.number.length();
    }

    public void input(String num) {
        this.number = num;
        this.len = this.number.length();
    }

    public void output() {
        System.out.println(this.number);
    }

    public void add(HugeInteger obj) {
        String newN = "";
        int flag = 0;
        int m, n;
        String next;

        if (len == obj.len) {
            for (int i = (len - 1); i >= 0; i--) {
                m = Character.getNumericValue(this.number.charAt(i));
                n = Character.getNumericValue(obj.number.charAt(i));
//                System.out.println(m);
//                System.out.println(n);
                next = String.valueOf((m + n + flag) % 10);

                if ((m + n + flag) >= 10) {
                    flag = 1;
                } else {
                    flag = 0;
                }
                newN = next + newN;
            }
            this.number = newN;
            if (flag == 1) {
                this.number = "1" + this.number;
            }
        } else if (len < obj.len) {
            for (int i = (obj.len-1); i >= (obj.len - len); i--) {
                m = Character.getNumericValue(this.number.charAt(i - obj.len + len));
                n = Character.getNumericValue(obj.number.charAt(i));
                next = String.valueOf((m + n + flag) % 10);

                if ((m + n + flag) >= 10) {
                    flag = 1;
                } else {
                    flag = 0;
                }
                newN = next + newN;
            }
            for (int i = (obj.len - len - 1); i >= 0; i--) {
                n = Character.getNumericValue(this.number.charAt(i));
                next = String.valueOf((0 + n + flag) % 10);

                if ((0 + n + flag) >= 10) {
                    flag = 1;
                } else {
                    flag = 0;
                }
                newN = next + newN;
            }
            this.number = newN;

        } else if (len > obj.len) {
            for (int i = (len-1); i >= (len - obj.len); i--) {
                m = Character.getNumericValue(this.number.charAt(i));
                n = Character.getNumericValue(obj.number.charAt(i - len + obj.len));
                next = String.valueOf((m + n + flag) % 10);

                if ((m + n + flag) >= 10) {
                    flag = 1;
                } else {
                    flag = 0;
                }
                newN = next + newN;
            }
            for (int i = (len - obj.len - 1); i >= 0; i--) {
                m = Character.getNumericValue(this.number.charAt(i));
                next = String.valueOf((m + 0 + flag) % 10);

                if ((m + 0 + flag) >= 10) {
                    flag = 1;
                } else {
                    flag = 0;
                }
                newN = next + newN;
            }
            this.number = newN;
        }
    }

    public boolean isEqualTo(HugeInteger obj) {
        if (this.number.equals(obj.number)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNotEqualTo(HugeInteger obj) {
        if (this.number.equals(obj.number)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isGreaterThan(HugeInteger obj) {
        if (this.number.equals(obj.number)) {
            return false;
        }

        if (len > obj.len) {
            return true;
        } else if (len < obj.len) {
            return false;
        } else {
            for (int i = 0; i < len; i++) {
                if (this.number.charAt(i) < obj.number.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }


    public boolean isLessThan(HugeInteger obj) {
        if (this.number.equals(obj.number)) {
            return false;
        }
        if (len < obj.len) {
            return true;
        } else if (len > obj.len) {
            return false;
        } else {
            for (int i = 0; i < len; i++) {
                if (this.number.charAt(i) > obj.number.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger obj) {
        if (this.number.equals(obj.number)) {
            return true;
        }
        if (len > obj.len) {
            return true;
        } else if (len < obj.len) {
            return false;
        } else {
            for (int i = 0; i < len; i++) {
                if (this.number.charAt(i) < obj.number.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean isLessThanOrEqualTo(HugeInteger obj) {
        if (this.number.equals(obj.number)) {
            return true;
        }
        if (len < obj.len) {
            return true;
        } else if (len > obj.len) {
            return false;
        } else {
            for (int i = 0; i < len; i++) {
                if (this.number.charAt(i) > obj.number.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}

