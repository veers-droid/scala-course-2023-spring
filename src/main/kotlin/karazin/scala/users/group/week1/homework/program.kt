package karazin.scala.users.group.week1.homework

import karazin.scala.users.group.week1.homework.adt.ErrorOr
import karazin.scala.users.group.week1.homework.model.PostView
import karazin.scala.users.group.week1.homework.services.getComments
import karazin.scala.users.group.week1.homework.services.getPosts
import karazin.scala.users.group.week1.homework.services.getUserProfile
import karazin.scala.users.group.week1.homework.services.getLikes
import karazin.scala.users.group.week1.homework.services.getShares

object program {

    fun getPostsViews(): ErrorOr<List<PostView>> =
             getUserProfile().flatMap { profile ->
                getPosts(profile.userId).flatMap { posts ->
                    posts.map { post ->
                        getPostView(post) }.fold(
                            ErrorOr.apply(emptyList())
                    ) { acc, item ->
                        acc.flatMap { list ->
                            item.map { list + it }
                        }
                    }
                }
            }


    fun getPostView(post: model.Post): ErrorOr<PostView> =
        getComments(post.postId).flatMap { comments ->
            getLikes(post.postId).flatMap { likes ->
                getShares(post.postId).map { shares ->
                    PostView(
                        post,
                        comments,
                        likes,
                        shares
                    )
                }
            }
        }
}