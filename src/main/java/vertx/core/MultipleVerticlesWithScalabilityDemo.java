package vertx.core;

import com.google.common.flogger.FluentLogger;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class MultipleVerticlesWithScalabilityDemo {

  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(RootVerticle.class, new DeploymentOptions().setInstances(2));
  }

  public static class RootVerticle extends AbstractVerticle {

    private static final FluentLogger LGR = FluentLogger.forEnclosingClass();

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
      LGR.atFine()
        .log("start: " + getClass().getName() + " on thread: " + Thread.currentThread().getName());
      startPromise.complete();

      vertx.deployVerticle(new VertA());
      vertx.deployVerticle(new VertB());
    }
  }

  public static class VertA extends AbstractVerticle {

    private static final FluentLogger LGR = FluentLogger.forEnclosingClass();

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
      LGR.atFine().log(
        "start: " + getClass().getName() + " on thread: " + Thread.currentThread().getName());
      startPromise.complete();
    }
  }

  public static class VertB extends AbstractVerticle {

    private static final FluentLogger LGR = FluentLogger.forEnclosingClass();

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
      LGR.atFine()
        .log("start: " + getClass().getName() + " on thread: " + Thread.currentThread().getName());
      startPromise.complete();
    }
  }

}
