package org.cryptomator.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.cryptomator.common.CatchingExecutors;

import java.util.concurrent.*;

public class CatchingExecutorsTest {

    // @Test
    // public void testCatchingThreadPoolExecutorCreation() {
    //     // Intention: Verifier que CatchingThreadPoolExecutor peut etre créer avec succés
    //     // Arrange
    //     ThreadFactory threadFactory = runnable -> new Thread(runnable, "TestThread");
    //     BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

    //     // Act
    //     ThreadPoolExecutor executor = new CatchingExecutors.CatchingThreadPoolExecutor(
    //             1, 2, 60, TimeUnit.SECONDS, workQueue, threadFactory
    //     );

    //     // Assert
    //     Assertions.assertNotNull(executor);
    //     executor.shutdown();
    // }

    @Test
    public void testCatchingScheduledThreadPoolExecutorCreation() {
        // Intention: Verifier que CatchingScheduledThreadPoolExecutor peut etre créer avec succés
        // Arrange
        ThreadFactory threadFactory = runnable -> new Thread(runnable, "ScheduledTestThread");

        // Act
        ScheduledThreadPoolExecutor scheduledExecutor = new CatchingExecutors.CatchingScheduledThreadPoolExecutor(
                1, threadFactory
        );

        // Assert
        Assertions.assertNotNull(scheduledExecutor);
        scheduledExecutor.shutdown();
    }
}