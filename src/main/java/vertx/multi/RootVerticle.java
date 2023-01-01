package vertx.multi;

import com.google.common.flogger.FluentLogger;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class RootVerticle extends AbstractVerticle {

  private static final FluentLogger LGR = FluentLogger.forEnclosingClass();

  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new RootVerticle());
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    LGR.atFine().log(">>> start: " + getClass().getName());
    startPromise.complete();
    vertx.deployVerticle(new VerticleA());
    vertx.deployVerticle(new VerticleB());
    vertx.deployVerticle(new VerticleC());
  }
}
