package vertx;

import com.google.common.flogger.FluentLogger;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle {

  private static final FluentLogger LGR = FluentLogger.forEnclosingClass();

  public static void main(String[] args) {
    Vertx.vertx().deployVerticle(new MainVerticle());
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    vertx.createHttpServer().requestHandler(req -> req.response()
      .putHeader("content-type", "text/plain")
      .end("Hello from Vert.x!")
    ).listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        LGR.atFine().log("HTTP server started on port 8888");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }
}
