import java.lang.String;

class CheckPassword{
    public static int longEnough(String password){
        if (password.length() >= 12){
            return 0;
        }
        return 1;
    }
    public static int isLeastTwoDigits(String password){
        int digit_index = 0;
        for (int i = 0; i < password.length(); i++){
            for (int y=0; y<10;y++){
                if (password.charAt(0)==y){
                    digit_index+=1;
                }
            }
        }
        if (digit_index>=2){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args){
        if (args.length == 0){
            System.err.println("Usage: java CheckPassword <password>");
            System.exit(0);
        }
        if (longEnough(args[0])==1 || isLeastTwoDigits(args[0])==1){
            System.out.println("Password is not valid");
        }
        else{
            System.out.println("Password is valid");
        }
    }
}