package vertx.multi;

import com.google.common.flogger.FluentLogger;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VerticleA extends AbstractVerticle {

  private static final FluentLogger LGR = FluentLogger.forEnclosingClass();

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    LGR.atFine().log(">>> start: " + getClass().getName());
    startPromise.complete();
  }
}
