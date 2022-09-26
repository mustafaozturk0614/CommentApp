package com.bilgeadam.commentapp.service;

import com.bilgeadam.commentapp.repository.ILikeRepository;
import com.bilgeadam.commentapp.repository.entity.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

private  final ILikeRepository likeRepository;


public Like save(Like like){

   return likeRepository.save(like);
}

}
