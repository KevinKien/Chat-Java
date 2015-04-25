package socket;

import javax.swing.JOptionPane;

public class Database {
  
      
    public String filePath;
    
    public Database(String filePath){
        this.filePath = filePath;
    }
    
    public boolean userExists(String username){
        String a=null;
        boolean check=false;
        try{
            
            Accessdb db=new Accessdb();
            a=db.Accessdb();
            String[] user,nick=null;
            user=a.split("/");
            int n=user.length;
            int j=0;
            for (j=0;j<n;j++){
            nick=user[j].split("-");
            if (username.equalsIgnoreCase(nick[0])){
                check=true;
                JOptionPane.showMessageDialog(null, "Tài khoản dã tồn tại");
                break;
            }
            }
            if (check) {
                return true;
                
            } else {
                return false;
            }
            
        }
        catch(Exception ex){
            System.out.println("Database exception : userExists()");
            return false;
        }
    }
    
    public boolean checkLogin(String username, String password){
        
        
        String a=null,b=null;
        Boolean check=false;
        try {
            
            Accessdb db=new Accessdb();
            a=db.Accessdb();
            System.out.println("Database bao gồm \n");
            System.out.println(a);
            System.out.println("Đăng nhập thành công");
            String[] user,nick=null;
            user=a.split("/");
            int n=user.length;
            int j=0;
            for (j=0;j<n;j++){
            nick=user[j].split("-");
            if (username.equalsIgnoreCase(nick[0])&&password.equalsIgnoreCase(nick[1])){
                check=true;
                
                break;
            }
            }
            if (check) {
               return true;
            }
            else {
                
                return false;
            }
            
            
        } catch (Exception e) {
            System.out.println("Database exception : userExists()");
            return false;
        }
    }
    
    public void addUser(String username, String password){
        String a=null;
        boolean check=false;
        try {
           Accessdb db=new Accessdb();
            a=db.Accessdb();
            System.out.println("Database bao gồm \n");
            System.out.println(a);
            String[] user,nick=null;
            user=a.split("/");
            int n=user.length;
            int j=0;
            for (j=0;j<n;j++){
            nick=user[j].split("-");
            if (username.equalsIgnoreCase(nick[0])){
                check=true;
                JOptionPane.showMessageDialog(null, "userExist");
                break;
            }
            }
            
            if (check) {
                
            }                   
            else {
                
                writedb wdb = new writedb();
                String code="Insert into info.login values ('"+username+"','"+password+"')";
                wdb.writedb(code);

               System.out.println(" Thêm vào DB thành công");
               System.out.println("Bảng Database \n");
               System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println("Dang ki that bai");
        }
    }
}
