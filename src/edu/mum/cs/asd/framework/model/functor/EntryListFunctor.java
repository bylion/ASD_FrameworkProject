package edu.mum.cs.asd.framework.model.functor;

import edu.mum.cs.asd.framework.model.IEntry;
import java.util.ArrayList;
import java.util.List;

public class EntryListFunctor implements IFunctor<IEntry, List<IEntry>> {

    private List<IEntry> entries = new ArrayList<>();

    @Override
    public void compute(IEntry e) {
        entries.add(e);
    }

    @Override
    public List<IEntry> getValue() {
        return entries;
    }
}
