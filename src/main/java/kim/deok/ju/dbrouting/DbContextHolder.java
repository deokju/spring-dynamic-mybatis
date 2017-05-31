package kim.deok.ju.dbrouting;

public class DbContextHolder {

   private static final ThreadLocal<DbType> contextHolder = new ThreadLocal<DbType>();

   public static void setDbType(DbType dbType) {
       if(dbType == null){
           throw new NullPointerException();
       }
      contextHolder.set(dbType);
   }

   public static DbType getDbType() {
      return (DbType) contextHolder.get();
   }

   public static void clearDbType() {
      contextHolder.remove();
   }

   public static void dbchanged(int dbNum) {
       switch (dbNum){
           case 1:
               DbContextHolder.setDbType(DbType.MASTER);
               break;
           case 2:
               DbContextHolder.setDbType(DbType.SLAVE);
               break;
           default:
               DbContextHolder.setDbType(DbType.USERDB);
       }
   }
}