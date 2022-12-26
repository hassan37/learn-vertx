package vertx.multi;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;

public class VerticleC extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    System.out.println(">>> start: " + getClass().getName());
    startPromise.complete();
    vertx.deployVerticle(VerticleCA.class.getName(), new DeploymentOptions().setInstances(5));
  }
}
