package br.com.finmentor.wallet.external_interfaces.web;

import br.com.finmentor.wallet.core.asset.service.AssetService;
import br.com.finmentor.wallet.core.asset.dto.CreateAssetDto;
import br.com.finmentor.wallet.core.asset.dto.UpdateAssetDto;
import br.com.finmentor.wallet.core.asset.projection.AssetDetailedProjection;
import br.com.finmentor.wallet.core.asset.projection.AssetProjection;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/assets")
public class AssetController {

    private AssetService assetService;

    @PostMapping
    public ResponseEntity<Void> createAsset(@RequestBody CreateAssetDto dto) {
        assetService.createAsset(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetDetailedProjection> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(assetService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<AssetProjection>> findAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return ResponseEntity.ok(assetService.findAll(page, size));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateAsset(@PathVariable UUID id, @RequestBody UpdateAssetDto dto) {
        assetService.updateAsset(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable UUID id) {
        assetService.deleteAsset(id);
        return ResponseEntity.noContent().build();
    }
}
