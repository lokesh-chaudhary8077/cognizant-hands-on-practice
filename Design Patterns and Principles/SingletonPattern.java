class SingletonPattern {
    private static SingletonPattern instance = null;

    private SingletonPattern() {
        System.out.println("Connecting to database");
    }

    public static synchronized SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("Executing:- " + sql);
    }

    public static void main(String[] args) {
        SingletonPattern conn = SingletonPattern.getInstance();
        
        conn.query("select * from students");

        SingletonPattern anotherConn = SingletonPattern.getInstance();
        System.out.println("Are both instances the same? " + (conn == anotherConn));
    }
}