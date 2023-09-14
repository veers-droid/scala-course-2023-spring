package karazin.scala.users.group.week1.topic

import java.util.*
import kotlin.collections.List

object model {

    data class UserProfile(val userId: UUID)
    data class Post(val userId: UUID, val postId: UUID)
    data class Comment(val userId: UUID, val postId: UUID)
    data class Like(val userId: UUID, val postId: UUID)
    data class Share(val userId: UUID, val postId: UUID)
    data class PostView(val post: Post, val comments: List<Comment>, val likes: List<Like>, val shares: List<Share>)

}