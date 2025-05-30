
function CreatePost() {

    return (
        <div className="big_container">
            <h1>Create Post page</h1>
            <form>
                {/* form for creating KeyboardBuild objects */}
                <label htmlFor="title">Title</label>
                <input id="title" type="text" />

                <label htmlFor="description">Description</label>
                <input id="description" type="text" />

                <label htmlFor="keyboard">Keyboard</label>
                <select id="keyboard"></select>
            </form>
        </div>
    )
}

export default CreatePost;