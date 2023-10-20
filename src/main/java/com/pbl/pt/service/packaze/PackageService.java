package com.pbl.pt.service.packaze;

import com.pbl.pt.repository.packaze.PackageEntity;
import com.pbl.pt.repository.packaze.PackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {
    private final PackageRepository packageRepository;

    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public List<Package> getAllPackages() {
        List<PackageEntity> bulkPassEntities = packageRepository.findAllByOrderByPackageName();
        return PackageModelMapper.INSTANCE.map(bulkPassEntities);
    }
}
