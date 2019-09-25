package problems;

/**
 * Problem468 Validate IP Address
 */
public class Problem468 {

    public String validIPAddress(String IP) {
        String[] ipStrs;
        if (IP.contains(".")) {
            ipStrs = IP.split("\\.");
            if (IP.endsWith(".")) {
                return "Neither";
            }
            if (ipStrs.length != 4) {
                return "Neither";
            }
            try {
                String decStr = "0123456789";
                for (String str : ipStrs) {
                    if (str.length() > 3 || Integer.parseInt(str) > 255 || (str.length() > 1 && str.startsWith("0"))) {
                        return "Neither";
                    }
                    for (char var : str.toCharArray()) {
                        if (!decStr.contains(String.valueOf(var))) {
                            return "Neither";
                        }
                    }
                }
            } catch (Exception e) {
                return "Neither";
            }

            return "IPv4";
        } else if (IP.contains(":")) {
            int count = 0;
            if (IP.startsWith("0")) {
                return "Neither";
            }
            if (IP.endsWith(":")) {
                return "Neither";
            }
            IP += ":";
            StringBuilder sb = new StringBuilder();
            String hexStr = "0123456789abcdef";
            char ch;
            for (int i = 0; i < IP.length(); i++) {
                ch = IP.charAt(i);
                if ((!hexStr.contains(String.valueOf(ch).toLowerCase()) && ch != ':')) {
                    return "Neither";
                }
                sb.append(ch);
                if (ch == ':') {
                    ++count;
                    if (count > 8) {
                        return "Neither";
                    }
                    if (sb.length() > 5 || sb.length() == 1) {
                        return "Neither";
                    }
                    sb = new StringBuilder();
                }
            }
            return "IPv6";
        }
        return "Neither";
    }
}