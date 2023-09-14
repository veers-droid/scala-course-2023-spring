package karazin.scala.users.group.week1.topic

import java.util.*
import kotlin.collections.List
import karazin.scala.users.group.week1.topic.adt.Option
import karazin.scala.users.group.week1.topic.model.PostView
import karazin.scala.users.group.week1.topic.services.getComments
import karazin.scala.users.group.week1.topic.services.getLikes
import karazin.scala.users.group.week1.topic.services.getUserProfile
import karazin.scala.users.group.week1.topic.services.getPosts
import karazin.scala.users.group.week1.topic.services.getShares

object program {

    fun getPostsViews(): Option<List<Option<PostView>>> =
            getUserProfile().flatMap { profile ->
                getPosts(profile.userId).flatMap { posts ->
                    Option.apply(posts.map { post -> getPostView(post) })
                }
            }

    fun getPostView(post: model.Post): Option<PostView> =
        getComments(post.postId).flatMap { comments ->
            getLikes(post.postId).flatMap { likes ->
                getShares(post.postId).map { shares ->
                    PostView(post, comments, likes, shares)
                }
            }
        }


}