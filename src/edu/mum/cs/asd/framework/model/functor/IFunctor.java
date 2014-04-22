package edu.mum.cs.asd.framework.model.functor;

public interface IFunctor<R> {

    public void compute();

    public R getValue();
}
