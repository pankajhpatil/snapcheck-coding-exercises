public class EncryptString {

    public static void main(String[] args) {
        String s = "if man was meant to stay on the ground god would have given us roots";
        System.out.println(encryptData(s));
        //Additional testing
//        System.out.println(encryptData("haveaniceday"));
//        System.out.println(encryptData("feedthedog"));
//        System.out.println(encryptData("f"));
//        System.out.println(encryptData("fa"));
//        System.out.println(encryptData("chillout"));
//        System.out.println(encryptData(null));

    }

    public static String encryptData(String inputS) {
        if (inputS != null && !"".equals(inputS)) {
            inputS = inputS.replaceAll(" ", "");
        } else {
            // return blank if input is null or empty
            return "";
        }
        //not checked for constrains as in problem statement expected outcome is not given for invalid datasets
        int len = inputS.length();
        int col = (int) Math.ceil(Math.sqrt(len));

        //Since I am going by col no need to check  for rows x columns >= L
        StringBuffer[] op = new StringBuffer[col];

        int i = 0;
        while (i < len) {
            char s = inputS.charAt(i);
            int index = i % col;
            if (op[index] != null) {
                op[index] = op[index].append(s);
            } else {
                op[index] = new StringBuffer().append(s);
            }
            i++;
        }

        // output string formation
        StringBuffer output = new StringBuffer();
        for (int k = 0; k < op.length; k++) {
            output.append(op[k]);
            if (k < col-1) {
                output.append(" ");
            }
        }
        return output.toString();
    }

}
