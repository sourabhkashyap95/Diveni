/*
  SPDX-License-Identifier: AGPL-3.0-or-later
  Diveni - The Planing-Poker App
  Copyright (C) 2022 Diveni Team, AUME-Team 21/22, HTWG Konstanz
*/
package io.diveni.backend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import io.diveni.backend.model.Session;
import org.springframework.data.mongodb.repository.*;

public interface SessionRepository {

  Session findBySessionID(String sessionID);

  Session findByAdminCookie(UUID adminCookie);

  Optional<Session> findByMemberID(String memberID);

  List<Session> findAll();

  Session save(Session setLastModified);

  void delete(Session session);

  void deleteAll();
}
