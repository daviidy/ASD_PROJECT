package banking.visitor;

public interface Visitable {

    double accept(Visitor visitor);
}
