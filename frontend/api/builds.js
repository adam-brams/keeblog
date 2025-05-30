const API_BASE_URL = process.env.NEXT_PUBLIC_API_URL;

export async function getBuilds() {
    const res = await fetch(`${API_BASE_URL}/api/builds`);
    if (!res.ok) {
        throw new Error('Failed to fetch builds');
    }
    return res.json();
}

export async function createBuild(buildData) {
    const res = await fetch(API_BASE_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(buildData),
    });

    if (!res.ok) {
        throw new Error('Failed to create build');
    }

    return res.json();
}