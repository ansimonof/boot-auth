package org.myorg.module.auth.access.context;

import org.myorg.module.auth.access.context.source.Source;

public abstract class Context<S extends Source> {

    private S source;

    public Context(S source) {
        this.source = source;
    }

    public S getSource() {
        return source;
    }
}
