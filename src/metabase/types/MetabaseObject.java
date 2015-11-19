package metabase.types;

import metabase.db.columns.Types;

public interface MetabaseObject {

    Types type();
    String repr();

}