package threading.syncronization;

public class StaticSync {
        private static Integer sync = 0;

        public void someMethod() {
                synchronized (sync) {
                        // synchronized on ClassLoader/JVM level
                }
        }
}