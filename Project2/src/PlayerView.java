public abstract class PlayerView implements  View {
    Player player;
    Level level;

    PlayerView(Level level){
        this.level = level;
        player = level.getPlayer();
    }
}