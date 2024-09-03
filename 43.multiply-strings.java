/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */

// @lc code=start

class Solution {
    /**
     * Convert String to Integer Array and add all array num
     * runtime: 96.03% (2 ms)
     * memory: 55.26% (42.3 MB)
     * @param num1
     * @param num2
     * @return
     */
    // public String multiply(String num1, String num2) {
    //     int[] arr = new int[num1.length() + num2.length()];
    //     int index1 = 0;
    //     int index2 = 0;
    //     for (int i = num1.length() - 1; i >= 0; i--) {
    //         int n1 = num1.charAt(i) - '0';
    //         index2 = 0;
    //         for (int j = num2.length() - 1; j >= 0; j--) {
    //             int n2 = num2.charAt(j) - '0';
    //             arr[index1 + index2] += (n1 * n2);
    //             index2++;
    //         }
    //         index1++;
    //     }

    //     for (int i = 0; i < arr.length; i++) {
    //         int temp = arr[i];
    //         int index = i;
    //         while (temp > 0) {
    //             if (index == i) {
    //                 arr[index] = temp % 10;
    //             } else {
    //                 arr[index] += temp % 10;
    //             }
    //             temp /= 10;
    //             index++;
    //         }
    //     }

    //     StringBuilder sb = new StringBuilder();
    //     for (int n : arr) {
    //         sb.append(n);
    //     }

    //     while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
    //         sb.deleteCharAt(sb.length() - 1);
    //     }
    //     return sb.reverse().toString();
    // }

    /**
     * runtime: 96.03% (2 ms)
     * memory: 78.82% (42.1 MB)
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        if ("1".equals(num1)) {
            return num2;
        }

        if ("1".equals(num2)) {
            return num1;
        }

        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';

                int product = n1 * n2;
                // Add previous value in result array into product
                product += result[i + j + 1];

                // Add the new product into the result array
                result[i + j + 1] = product % 10;
                result[i + j] += product / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : result) {
            // 去掉前面0
            if (sb.length() == 0 && n == 0) {
                continue;
            }
            sb.append(n);
        }

        return sb.toString();
    }

}
// @lc code=end

