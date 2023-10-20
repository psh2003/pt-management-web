package com.pbl.pt.service.packaze;

import com.pbl.pt.repository.packaze.PackageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PackageModelMapper {
    PackageModelMapper INSTANCE = Mappers.getMapper(PackageModelMapper.class);

    List<com.pbl.pt.service.packaze.Package> map(List<PackageEntity> packageEntities);

}
