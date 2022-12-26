package vertx.multi;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class RootVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new RootVerticle());
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    System.out.println(">>> start: " + getClass().getName());
    startPromise.complete();
    vertx.deployVerticle(new VerticleA());
    vertx.deployVerticle(new VerticleB());
    vertx.deployVerticle(new VerticleC());
  }
}
