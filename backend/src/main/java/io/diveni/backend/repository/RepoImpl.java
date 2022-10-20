package io.diveni.backend.repository;

import io.diveni.backend.model.Session;

import java.util.*;

public class RepoImpl implements SessionRepository{

  Map<String,Session> db = new HashMap<>();

  @Override
  public Session findBySessionID(String sessionID) {
    return db.values().stream()
      .filter(s -> s.getSessionID().equals(sessionID))
      .findFirst().get();
  }

  @Override
  public Session findByAdminCookie(UUID adminCookie) {
    return db.values().stream()
      .filter(s -> s.getAdminCookie().equals(adminCookie))
      .findFirst().get();
  }

  @Override
  public Optional<Session> findByMemberID(String memberID) {
      return db.values().stream()
        .filter(s -> s.getMembers().stream().anyMatch(m -> m.getMemberID().equals(memberID)))
        .findFirst();
  }

  @Override
  public List<Session> findAll() {
    return new ArrayList<>(db.values());
  }

  @Override
  public Session save(Session s) {
    return db.put(s.getSessionID(),s);
  }

  @Override
  public void delete(Session session) {
    db.remove(session.getSessionID());
  }

  @Override
  public void deleteAll() {
    db = new HashMap<>();
  }
}
