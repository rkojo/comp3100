import java.util.ArrayList;

public class customfit implements serverImplementation{
    ArrayList<Server> serverList;
    ArrayList<Server> serverarr;
    int cores;
    public customfit(ArrayList<Server> servers, int core) {
        serverList = servers;
        cores = core;
    }
    @Override
    public Server returnServer() {
        serverList.sort(new serverCompare());
        Server s = null;

        for(int i = 0; i<serverList.size(); i++) {
            //just turn all servers on - this takes time so open all no matter the fitness
            //also if the server is empty
            if(serverList.get(i).rjobs == 0 && serverList.get(i).wjobs == 0) {
                s = serverList.get(i);
               
            }
        }
        if(s == null) {
        for(int i = 0; i<serverList.size(); i++) {
            if(serverList.get(i).state.equals("active") && serverList.get(i).curstarttime == 0 ) {
                s = serverList.get(i);
                
            }
        }
    }
        if(s == null) {
            //if they are all on, it moves to here where fitness is considered.
            // for(int i = 0; i<serverList.size(); i++) {
            //     if((serverList.get(i).cores - cores) < fitness) {
            //         s = serverList.get(i);
            //     }
            // }
            s = serverList.get(0);
            //int strength = serverList.get(0).cores - cores;
            for(int i = 0; i<serverList.size(); i++) {
                // int serverstrength = serverList.get(i).cores - cores;
                // && strength < serverstrength
                if(serverList.get(i).wjobs < s.wjobs )  {
              //      strength = serverList.get(i).cores - cores;
                    s = serverList.get(i);
                
                }
            }
        }
        
        return s;
    }
    
}