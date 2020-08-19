package tasks.task2;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class UserAggregator {

    static Set<User> uniqueUsers = new HashSet<>();

    @Test
    public void toFix() {

        uniqueUsers.add(new User("Max", "Kuznietsov", 27));
        uniqueUsers.add(new User("Dmytro", "Diland", 23));
        uniqueUsers.add(new User("Igor", "Yierohin", 11));
        uniqueUsers.add(new User("Max", "Kuznietsov", 27));

        Assert.assertEquals(uniqueUsers.size(), 3);

    }
}
