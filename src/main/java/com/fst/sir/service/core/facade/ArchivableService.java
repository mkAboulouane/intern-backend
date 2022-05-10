package com.fst.sir.service.core.facade;

import com.fst.sir.bean.Archivable;

public interface ArchivableService<T extends Archivable> {

    /**
     * Prepare archivage et desarchivage
     */
    int prepare(T object);

    /**
     * Prepare archivage
     */
    int prepareArchivage(T object);

    /**
     * Prepare desarchivage
     */
    int prepareDesarchivage(T object);


}
