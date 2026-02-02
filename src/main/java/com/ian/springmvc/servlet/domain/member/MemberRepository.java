package com.ian.springmvc.servlet.domain.member;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 싱글톤이기 때문에 생성자를 private으로 막음
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberRepository {

    // 동시성이 고려되지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
    private static Map<Long, Member> store = new HashMap<Long, Member>();
    private static long sequence = 0L;

    // 싱글톤
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);

        return member;
    }

    public Member findById(long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clear() {
        store.clear();
    }
}
