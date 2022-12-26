package vertx.multi;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VerticleCA extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    System.out.println(
      ">>> start: " + getClass().getName() + " on thread: " + Thread.currentThread().getName());
    startPromise.complete();
  }
}
