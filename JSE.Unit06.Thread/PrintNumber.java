package techmatter.java6;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;


class PrintNumber implements Runnable{
//        private int number = 1;
//        private boolean alive = true;
	private Integer number = new Integer(1);

//        public int getNumber(){ return number; }
//        
//        public void setAlive(boolean alive){ this.alive = alive; }
        
	public void run(){
		Thread current = Thread.currentThread();
		//while(alive){
                    while(true){
			number++;
			System.out.println(current.getName() +" number is \""+ number +"\"");
			try{
				Thread.sleep(300);
			}catch(Exception e){ e.printStackTrace(); }
			if(number % 10 == 0) break;
		}
		System.out.println(current.getName() + " is stopped!");
	}
}