package com.mm.marketmanager.services.impl;

import com.mm.marketmanager.api.exceptions.customs.BadRequestException;
import com.mm.marketmanager.api.exceptions.customs.NotFoundException;
import com.mm.marketmanager.api.models.requests.BranchRequest;
import com.mm.marketmanager.api.models.responses.BranchResponse;
import com.mm.marketmanager.persistence.repositories.BranchRepository;
import com.mm.marketmanager.services.contracts.BranchService;
import com.mm.marketmanager.utils.logs.WriteLogs;
import com.mm.marketmanager.utils.mappers.BranchMapper;
import lombok.Locked;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the BranchService interface for managing branches
 * in the Market Manager application.
 *
 * @author caito
 *
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;

    /* Adds a new branch to the system.
     *
     * @param request The branch request containing branch details.
     */
    @Override
    @Transactional
    public void addBranch(BranchRequest request) {
        log.info(WriteLogs.logInfo("--> Adding new branch service"));
        this.validateBranch(request);
        branchRepository.save(BranchMapper.mapToEntity(request));
    }

    /* Retrieves a branch by its ID.
     *
     * @param id The ID of the branch to retrieve.
     * @return The branch response containing branch details.
     */
    @Override
    @Transactional(readOnly = true)
    public BranchResponse getBranchById(Long id) {
        log.info(WriteLogs.logInfo("--> Getting branch by id service"));
        return BranchMapper.mapToDto(branchRepository.findById(id).orElseThrow(
                () -> {
                    log.warn(WriteLogs.logWarning("--> Branch with id " + id + " not found"));
                    return new NotFoundException("Branch with id " + id + " not found.");
                }));
    }

    /* Retrieves all branches in the system.
     *
     * @return A list of branch responses containing branch details.
     */
    @Override
    @Transactional(readOnly = true)
    public List<BranchResponse> getAllBranches() {
        log.info(WriteLogs.logInfo("--> Getting all branches service"));
        return branchRepository.findAll().stream().map(BranchMapper::mapToDto).toList();
    }

    /* Updates an existing branch.
     *
     * @param id The ID of the branch to update.
     * @param request The branch request containing updated branch details.
     * @return The updated branch response containing branch details.
     */
    @Override
    @Transactional
    public BranchResponse updateBranch(Long id, BranchRequest request) {
        log.info(WriteLogs.logInfo("--> Updating branch service"));
        var branch = branchRepository.findById(id).orElseThrow(
                () -> {
                    log.warn(WriteLogs.logWarning("--> Branch with id " + id + " not found"));
                    return new NotFoundException("Branch with id " + id + " not found.");
                }
        );
        if (request.getName() != null && !request.getName().isEmpty()) {
            branch.setName(request.getName());
        }
        if (request.getAddress() != null && !request.getAddress().isEmpty()) {
            branch.setAddress(request.getAddress());
        }
        if (request.getCuit() != null && !request.getCuit().isEmpty()) {
            branch.setCuit(request.getCuit());
        }
        if (request.getPhone() != null && !request.getPhone().isEmpty()) {
            branch.setPhone(request.getPhone());
        }
        if (request.getEmail() != null && !request.getEmail().isEmpty()) {
            branch.setEmail(request.getEmail());
        }
        return BranchMapper.mapToDto(branchRepository.save(branch));
    }

    /* Deletes a branch by its ID.
     *
     * @param id The ID of the branch to delete.
     */
    @Override
    @Transactional
    public void deleteBranch(Long id) {
        log.info(WriteLogs.logInfo("--> Deleting branch service"));
        var branch = branchRepository.findById(id).orElseThrow(
                () ->     {
                    log.warn(WriteLogs.logWarning("--> Branch with id " + id + " not found"));
                    return new NotFoundException("Branch with id " + id + " not found.");
                }
        );
        branchRepository.delete(branch);
    }

    /* Validates the branch request data.
     *
     * @param request The branch request to validate.
     */
    private void validateBranch(BranchRequest request) {
        log.info(WriteLogs.logInfo("--> Validating branch..."));
        List<String> errorrs = new ArrayList<>();
        if (request.getName() == null || request.getName().isEmpty()) {
            errorrs.add("Branch name is required.");
        }
        if (request.getAddress() == null || request.getAddress().isEmpty()) {
            errorrs.add("Branch address is required.");
        }
        if (request.getCuit() == null || request.getCuit().isEmpty()) {
            errorrs.add("Branch CUIT is required.");
        }
        if (request.getPhone() == null || request.getPhone().isEmpty()) {
            errorrs.add("Branch phone is required.");
        }
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            errorrs.add("Branch email is required.");
        }
        if (!errorrs.isEmpty()) {
            log.error(WriteLogs.logError("Validation errors: " + String.join(", ", errorrs)));
            throw new BadRequestException(errorrs);
        }
    }
}
