package org.ga2.buna.service.popularityplan;

import org.ga2.buna.dto.planboard.PopDTO;

import java.util.List;

public interface PlanTop40 {
    List<PopDTO> find40();
}