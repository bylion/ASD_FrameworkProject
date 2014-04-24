package edu.mum.cs.asd.framework.model.functor;

import edu.mum.cs.asd.framework.model.Entry;
import java.util.ArrayList;
import java.util.List;

public class EntryListFunctor implements IFunctor<Entry, List<Entry>> {

    private List<Entry> entries = new ArrayList<>();

    @Override
    public void compute(Entry e) {
        entries.add(e);
    }

    @Override
    public List<Entry> getValue() {
        return entries;
    }
}
