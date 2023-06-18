public class MyThreadClass extends Thread {
    
    public int id;
    public MyThreadClass(int id){
        this.id=id;
    }
    @Override
    public void run(){
        try{
            System.out.println("Thread Class Object "+id);
          }catch(Exception e){

        }
    }
    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            MyThreadClass ob = new MyThreadClass(i);
            ob.start();

        }
    }
    
}
