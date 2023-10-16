import java.io.*;
import java.util.*;

class User {
    int level;
    String name;

    public User(int level, String name) {
        this.level = level;
        this.name = name;
    }
}

class Room{
    boolean started;
    TreeSet<User> users = new TreeSet<>(Comparator.comparing(u -> u.name));

    int level;

    Room(int level, User user){
        this.level = level;
        users.add(user);
    }
    void addUser(User user) {
        users.add(user);
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner sc = new Scanner(System.in);
        List<Room> rooms = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int p = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.valueOf(st.nextToken());
            String name = st.nextToken();
            boolean ch = false;
            for (Room room : rooms) {
                if (!room.started && room.level - 10 <= level && level <= room.level + 10){
                    ch = true;
                    room.addUser(new User(level, name));
                    if (room.users.size() == m)
                        room.started = true;
                    break;
                }
            }
            if (!ch){
                Room room = new Room(level, new User(level, name));
                rooms.add(room);
                if (m == 1)
                    room.started = true;
            }
        }
        for (Room room : rooms) {
            if (room.started)
                System.out.println("Started!");
            else
                System.out.println("Waiting!");
            for (User user : room.users){
                System.out.println(user.level + " " + user.name);
            }
        }

    }
}