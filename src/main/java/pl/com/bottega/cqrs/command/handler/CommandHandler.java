package pl.com.bottega.cqrs.command.handler;

public interface CommandHandler<C, R> {
  R handle(C command);
}
