package practice;

public class Download {
    String fileName = "";
    String fileType = "";
    int fileData = 0;

    public Download(String name, String fName, int stroage) {
    	this.fileData = stroage;
        this.fileName = name;
        this.fileType = fName;
        this.processing(this.fileName,this.fileType,this.fileData);
    }

    public void processing(String name, String fName,int storage) {
        Thread downloadThread = new Thread(new Runnable() {
            public void run() {
                StringBuilder sb = new StringBuilder();
                try {
                    for (int i = 1; i <= storage; i++) {
                        sb.append("#");
                        System.out.print("\r[Download started] "+name+"["+ sb.toString()+"]");
                        
                        Thread.sleep(500);
                        clear();
                    }
                    
                    System.out.print("\r["+name+"."+fName+" Download complete]   ");
                    System.out.println();
                } catch (InterruptedException e) {
                    System.out.println("File download has been interrupted!");
                }
            }
        });
        downloadThread.start();
    }
    public void clear() {
    	  for (int i = 0; i < 20; i++) {
    	        System.out.println();
    	    }
    	}
    }
    



