package com.example.shop.member.repository;

import com.example.shop.member.entity.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository {

    private final Map<Long, Member> store = new HashMap<>();
    private long sequence = 0L;

    @Override
    public void save(Member member) {
        store.put(++sequence, member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return store.values().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }

    @Override
    public void delete(Member member) {
        store.values().remove(member);
    }
}
