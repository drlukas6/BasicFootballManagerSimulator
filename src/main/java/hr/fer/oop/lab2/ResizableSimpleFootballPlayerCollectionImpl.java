package hr.fer.oop.lab2;

public class ResizableSimpleFootballPlayerCollectionImpl extends SimpleFootballPlayerCollectionImpl {

    public ResizableSimpleFootballPlayerCollectionImpl(int maxPlayers){
        super(maxPlayers);
    }

    @Override
    public boolean add(FootballPlayer player){
        if(!contains(player)){
            if(size()==maxPlayers){
                maxPlayers = maxPlayers * 2;
                FootballPlayer[] newFootballPlayerList = new FootballPlayer[maxPlayers];
                System.out.println("New size is: " + maxPlayers);
                int i=0;
                //Copying players
                for (FootballPlayer player1:footballPlayerList) {
                    newFootballPlayerList[i] = player1;
                    i++;
                }
                footballPlayerList = newFootballPlayerList;
            }
            footballPlayerList[size()] = player;
            System.out.println("Players successfully added!");
            return true;
        }
        return false;
    }

    @Override
    public int getMaxSize(){
        return maxPlayers;
    }
}
