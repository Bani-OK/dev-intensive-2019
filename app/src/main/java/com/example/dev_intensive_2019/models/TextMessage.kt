package com.example.dev_intensive_2019.models

import java.util.*

class TextMessage(id: String,
                 from: User?,
                 chat: Chat,
                 isIncoming: Boolean = false,
                 date: Date = Date(),
                 var Text: String?
) : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage(): String {
        TODO("Not yet implemented")
    }
}