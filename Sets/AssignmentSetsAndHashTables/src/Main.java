public class Main {
    public static void main(String[] args) {
        FaceLikes main = new FaceLikes();
        main.buildMaps();
        main.getAllUsers();
        main.getLikes("Anthony");
        main.getLikedBy("Anthony");
        main.getLikes("Mike");
        main.getLikedBy("Mike");
        main.getLikes("Sara");
        main.getLikedBy("Sara");
    }
}
