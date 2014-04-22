package edu.mum.cs.asd.framework.model.functor;

public interface IFunctor<T, R> {

    public void compute(T t);

    public R getValue();
}
